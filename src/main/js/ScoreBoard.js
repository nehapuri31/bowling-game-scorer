import React from 'react';
import  {PropTypes} from 'prop-types';

import Frame from './Frame';

const ScoreBoard = ({rolls, scores, sum}) => {
        const frames = [];
        let i = 0;

        let isTen = function (pins) {
            return pins === 10;
        };
        for (let frame = 0; frame < 10; frame++) {
            let scoreFrame = scores[frame];
            let rollOne = rolls[i];
            let rollTwo = isTen(rollOne) ? 0 : rolls[i + 1];

            i += isTen(rollOne) ? 1 : 2;

            frames.push(<Frame key={i} rollOne={rollOne} rollTwo={rollTwo} score={scoreFrame}/>)
        }
        return (
            <div>
                <div className="frames">{frames}</div>
                <span className="display-1 alert-dark">Score = {sum}</span>
            </div>
        )
    }
    ;

ScoreBoard.propTypes = {
    rolls: PropTypes.array.isRequired,
    scores: PropTypes.array.isRequired,
    sum: PropTypes.number
};

export default ScoreBoard;