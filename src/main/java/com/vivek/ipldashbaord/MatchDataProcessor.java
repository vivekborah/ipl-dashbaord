package com.vivek.ipldashbaord;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;



import com.vivek.ipldashbaord.model.MatchIpl;



import org.springframework.batch.item.ItemProcessor;


public class MatchDataProcessor  implements ItemProcessor<MatchInput, MatchIpl>{
    
    //private static final Logger log = LoggerFactory.getLogger(MatchDataProcessor.class);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
    
      @Override
      public MatchIpl process(final MatchInput matchInput) throws Exception {

            MatchIpl match =new MatchIpl();
            match.setId(Long.parseLong(matchInput.getId()));
            match.setCity(matchInput.getCity());
            match.setMatchDate(LocalDate.parse(matchInput.getMatchDate(),formatter));
            match.setPlayerOfMatch(matchInput.getPlayerOfMatch());
            match.setVenue(matchInput.getVenue());
            match.setNeutralVenue(matchInput.getNeutralVenue());
            match.setMatchWinner(matchInput.getMatchWinner());
            String firstInningsTeam, secondInningsteam;

            if("bat".equals(matchInput.getTossDecision())){
                firstInningsTeam = matchInput.getTossWinner();
                secondInningsteam = matchInput.getTossWinner().equals(matchInput.getTeam1()) ? matchInput.getTeam2() : matchInput.getTeam1();
            }
            else{

                secondInningsteam = matchInput.getTossWinner();
                firstInningsTeam = matchInput.getTossWinner().equals(matchInput.getTeam1()) ? matchInput.getTeam2() : matchInput.getTeam1();
            }

            match.setTeam1(firstInningsTeam);
            match.setTeam2(secondInningsteam);

            match.setTossWinner(matchInput.getTossWinner());
            match.setTossDecision(matchInput.getTossDecision());
            match.setResult(matchInput.getResult());
            match.setResultMargin(matchInput.getResultMargin());
            match.setUmpire1(matchInput.getUmpire1());
            match.setUmpire2(matchInput.getUmpire2());


            return match;
      }
        
            
 
    
    


}
