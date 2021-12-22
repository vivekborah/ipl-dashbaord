
import {React} from 'react';

export const MatchDetailCard = ({matchipl}) =>  {
    if (!matchipl) return null;
    return (
    <div className="MatchDetailCard">
    
     <h3> Latest Matches </h3>
     <h4> Match Details </h4>
     <h4>{matchipl.team1} vs {matchipl.team2}</h4>
    </div>
  );
}
