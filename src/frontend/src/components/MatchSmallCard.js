
import {React} from 'react';

export const MatchSmallCard = ({matchipl}) =>  {
  return (
    <div className="MatchSmallCard">
    <p> {matchipl.team1} vs {matchipl.team2}</p>

    </div>
  );
}
