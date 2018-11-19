import React from 'react';
import  {PropTypes} from 'prop-types';

import Roll from './Roll';

const RollButtons = ({onClick, pinsDown}) =>  {
  const pins = [];
  for (let i = 0; i < 11; i++) {
    const isDeactivated = i > 10 - pinsDown;
    pins.push(<Roll key={i} number={i} onClick={onClick} deActivated={isDeactivated}/>);
  }

  return (<div className="btn-toolbar">{pins}</div>);
};

RollButtons.defaultPropTypes = {
  pinsDown: 0
};

RollButtons.propTypes = {
  onClick: PropTypes.func.isRequired,
  pinsDown: PropTypes.number
};

export default RollButtons;