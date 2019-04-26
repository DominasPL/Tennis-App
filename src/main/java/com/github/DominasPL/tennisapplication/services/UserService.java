package com.github.DominasPL.tennisapplication.services;

import com.github.DominasPL.tennisapplication.domain.model.*;
import com.github.DominasPL.tennisapplication.domain.repositories.CommentRepository;
import com.github.DominasPL.tennisapplication.domain.repositories.MatchRepository;
import com.github.DominasPL.tennisapplication.domain.repositories.RankingRepository;
import com.github.DominasPL.tennisapplication.domain.repositories.UserRepository;
import com.github.DominasPL.tennisapplication.dtos.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private RankingRepository rankingRepository;
    private MatchRepository matchRepository;
    private CommentRepository commentRepository;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, RankingRepository rankingRepository, MatchRepository matchRepository, CommentRepository commentRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.rankingRepository = rankingRepository;
        this.matchRepository = matchRepository;
        this.commentRepository = commentRepository;
    }

    @Transactional
    public void registerUser(RegistrationFormDTO form) {
        User user = Converters.convertToUser(form);
        user.setPassword(passwordEncoder.encode((user.getPassword())));
        logger.info("Rejestracja użytjownika: " + user);
        userRepository.save(user);
        //Stworzenie pustego userDetails (tylko z id uzytkownika)
        UserDetails userDetails = new UserDetails();
        userDetails.setId(user.getId());
        user.setUserDetails(userDetails);
        //Stworzenie pustego rankingu dla danego uzytkownika. Ilosc pkt na start = 500
        Ranking ranking = new Ranking();
        ranking.setId(user.getId());
        ranking.setMatchesPlayed(0L);
        ranking.setWon(0L);
        ranking.setLost(0L);
        ranking.setWinPercentage(0.0);
        ranking.setPoints(500L);
        user.setRanking(ranking);
        userRepository.save(user);
        logger.info("Użytkownik zarejestrowany: " + user);

    }

    @Transactional
    public void editUser(EditUserDTO editUserDTO) {
        Optional<User> optionalUser = userRepository.findByUsername(editUserDTO.getUsername());
        User loadedUser = optionalUser.orElse(null);
        User user = Converters.convertToUser(loadedUser, editUserDTO);
        logger.info("Edycja uzytkownika: " + user);
        userRepository.save(user);
        logger.info("Użytkownik zedytowany: " + user);

    }

    @Transactional
    public String duel(List<UserDTO> users) {
        Random random = new Random();
        Double averageScorePlayer1 = users.get(0).getPoints() + users.get(0).getWinPercentage() * 100 + random.nextInt(100) + 1;
        Double averageScorePlayer2 = users.get(1).getPoints() + users.get(1).getWinPercentage() * 100 + random.nextInt(100) + 1;
        Optional<User> optionalUser1 = userRepository.findByUsername(users.get(0).getUsername());
        Optional<User> optionalUser2 = userRepository.findByUsername(users.get(1).getUsername());

        User user1 = optionalUser1.orElse(null);
        User user2 = optionalUser2.orElse(null);


        int user1Score = averageScorePlayer1.intValue();
        int user2Score = averageScorePlayer2.intValue();

        while (true) {
            if (random.nextInt(user1Score) + 1 > random.nextInt(user2Score) + 1) {
                Ranking ranking1 = user1.getRanking();
                ranking1.setPoints(ranking1.getPoints() + 25);
                ranking1.setWon(ranking1.getWon() + 1);
                ranking1.setMatchesPlayed(ranking1.getMatchesPlayed() + 1);
                Ranking ranking2 = user2.getRanking();
                ranking2.setPoints(ranking2.getPoints() - 25);
                ranking2.setLost(ranking2.getLost() + 1);
                ranking2.setMatchesPlayed(ranking2.getMatchesPlayed() + 1);
                userRepository.save(user1);
                userRepository.save(user2);
                //TODO ZROBIC Metode
                Ranking ranking1Updated = user1.getRanking();
                double winPercentage1 = (double)(ranking1Updated.getWon()) / (ranking1Updated.getMatchesPlayed());
                ranking1Updated.setWinPercentage((double) Math.round(winPercentage1 * 100) / 100);
                userRepository.save(user1);
                Ranking ranking2Updated = user2.getRanking();
                double winPercentage2 = (double)(ranking2Updated.getWon()) / (ranking2Updated.getMatchesPlayed());
                ranking2Updated.setWinPercentage((double)Math.round(winPercentage2 * 100) /100);
                addMatch(user1, user2, user1.getUsername());
                userRepository.save(user1);
                userRepository.save(user2);
                return user1.getUsername();

            } else if (random.nextInt(user1Score) + 1 < random.nextInt(user2Score) + 1) {
                Ranking ranking2 = user2.getRanking();
                ranking2.setPoints(ranking2.getPoints() + 25);
                ranking2.setWon(ranking2.getWon() + 1);
                ranking2.setMatchesPlayed(ranking2.getMatchesPlayed() + 1);
                Ranking ranking1 = user1.getRanking();
                ranking1.setPoints(ranking1.getPoints() - 25);
                ranking1.setLost(ranking1.getLost() + 1);
                ranking1.setMatchesPlayed(ranking1.getMatchesPlayed() + 1);
                userRepository.save(user1);
                userRepository.save(user2);
                //TODO ZROBIC Metode
                Ranking ranking2Updated = user2.getRanking();
                double winPercentage1 = (double)(ranking2Updated.getWon()) / (double)(ranking2Updated.getMatchesPlayed());
                ranking2Updated.setWinPercentage((double)Math.round(winPercentage1 * 100) / 100);
                userRepository.save(user2);
                Ranking ranking1Updated = user1.getRanking();
                double winPercentage2 = (double)(ranking1Updated.getWon()) / (double)(ranking1Updated.getMatchesPlayed());
                ranking1Updated.setWinPercentage((double)Math.round(winPercentage2 * 100) / 100);
                addMatch(user1, user2, user2.getUsername());
                userRepository.save(user1);
                userRepository.save(user2);
                return user2.getUsername();

            } else if (random.nextInt(user1Score) + 1 == random.nextInt(user2Score) + 1) {
                logger.debug("Remis. Potrzebna dogrywka!");
            }
        }

    }

    @Transactional
    public void addMatch(User user1, User user2, String winner) {
        Match match = new Match();
        match.setWinner(winner);
        matchRepository.save(match);
        Optional<Match> optionalMatch = matchRepository.findFirstOrderByDateDesc();
        Match match1 = optionalMatch.orElse(null);
        user1.getMatches().add(match1);
        user2.getMatches().add(match1);
    }

    @Transactional
    public void saveComment(CommentMatchDTO commentMatchDTO) {
        Match matchById = matchRepository.getOne(commentMatchDTO.getMatch_id());
        User user = userRepository.findByUsername(commentMatchDTO.getCreatedBy()).get();
        Comment comment = new Comment();
        comment.setUser(user);
        comment.setMatch(matchById);
        comment.setText(commentMatchDTO.getText());
        commentRepository.save(comment);
    }

    public List<User> findAllUsers() {

        List<User> allUsers = userRepository.findAll();
        if (allUsers == null) {
            logger.debug("Nie znaleziono użytkowników.");
            return null;
        }

        logger.debug("Znaleziono rankingi użytkowników.");
        return allUsers;
    }

    public UserDTO findUserByUsername(String username) {
        if (username == null) {
            throw new IllegalArgumentException("Nazwa użytkownika musi być podana!");
        }

        Optional<User> optionalUser = userRepository.findByUsername(username);

        User user = optionalUser.orElse(null); // zwroci usera albo bedzie null
        if (user == null) {
            logger.debug("Nie znaleziono użytkownika dla nazwy: " + username);
            return null;
        }

        logger.debug("Znaleziono użytkownika dla nazwy: " + username);
        UserDTO userDTO = Converters.convertToUserDTO(user); // jezeli user jest to konwersja do user dto
        return userDTO;
    }

    public UserDTO findUserByEmail(String email) {
        if (email == null) {
            throw new IllegalArgumentException("Email musi być podany!");
        }

        Optional<User> optionalUser = userRepository.findByEmail(email);

        User user = optionalUser.orElse(null);
        if (user == null) {
            logger.debug("Nie znaleziono użytkownika dla nazwy email: " + email);
            return null;
        }

        logger.debug("Znaleziono użytkownika dla nazwy email: " + email);
        UserDTO userDTO = Converters.convertToUserDTO(user);
        return userDTO;
    }

    public Long findUserPoints(UserDTO userDTO) {
        if (userDTO == null) {
            throw new IllegalArgumentException("Niepoprawny argument!");
        }

        Optional<Ranking> optionalRanking = rankingRepository.findById(userDTO.getId());

        Ranking ranking = optionalRanking.orElse(null);
        if (ranking == null) {
            logger.debug("Nie znaleziono rankingu!");
        }

        logger.debug("Znaleziono ranking!");
        return ranking.getPoints();
    }


    public List<Ranking> findAllRankings() {
        List<Ranking> allRankings = rankingRepository.findAll();
        return allRankings;
    }

    public UserDTO findUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        User user = optionalUser.orElse(null);

        if (user == null) {
            logger.debug("Nie znaleziono Usera");
        }

        UserDTO userDTO = Converters.convertToUserDTO(user);

        return userDTO;
    }

    public List<MatchDTO> findUserMatches(String username) {
        if (username == null) {
            throw new IllegalArgumentException("Nazwa użytkownika musi być podana!");
        }

        Optional<User> optionalUser = userRepository.findByUsername(username);
        User user = optionalUser.orElse(null); // zwroci usera albo bedzie null
        if (user == null) {
            return null;
        }

        List<MatchDTO> matchDTOS = Converters.convertToMatchDTO(user);
        return matchDTOS;
    }

    public List<Match2DTO> findAllMatches() {

        List<Match> allMatches = matchRepository.findAll();
        if (allMatches == null) {
            return null;
        }

        List<Match2DTO> matches = Converters.convertToMatch2DTO(allMatches);

        return matches;

    }

    public List<CommentDTO> findAllCommentsByMatchId(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id musi byc podane!");
        }

        List<Comment> matchComments = commentRepository.findByMatchId(id);
        List<CommentDTO> comments = Converters.convertToCommentDTO(matchComments);

        return comments;
    }


    public Match2DTO findMatchById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id musi byc podane!");
        }

        Match match = matchRepository.findById(id).get();
        Match2DTO match2DTO = Converters.convertToMatch2DTO(match);

        return match2DTO;

    }
}


