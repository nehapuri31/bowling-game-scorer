import React from 'react';
import  {PropTypes} from 'prop-types';

const Frame = ({rollOne, rollTwo, score}) => {
    let isStrike = function () {
        return rollOne === 10;
    };
    let isSpare = function () {
        return rollOne + rollTwo === 10;
    };
    const lastRoll = () => {
        //If Strike is there
        return isStrike() ? <span>{"X"}</span>
            : isSpare() ? <span>{"/"}</span> : <span>{rollTwo}</span>;
    };

    return (
        <div className="frame">
            <span>{rollOne}</span>
            {lastRoll()}
            <p>{score ? score : ""}</p>
        </div>
    );
};

Frame.propTypes = {
    rollOne: PropTypes.number,
    rollTwo: PropTypes.number,
    score: PropTypes.number
};

export default Frame;