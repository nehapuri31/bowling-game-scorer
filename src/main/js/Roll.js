import React from 'react';
import {PropTypes} from 'prop-types';

const Roll = ({number, onClick, deActivated}) => (
    <button type="button" className="btn btn-primary"
            disabled={deActivated}
            onClick={() => {
                onClick(number)
            }}>
        {number}
    </button>);

Roll.propTypes = {
    number: PropTypes.number.isRequired,
    onClick: PropTypes.func.isRequired,
    deActivated: PropTypes.bool
};

export default Roll;