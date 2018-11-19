import React from 'react';
import  {PropTypes} from 'prop-types';

const ResetButton = ({onClick}) => {
    return (    <button type="button" className="btn float-right btn-danger"
                        onClick={() => {
                            onClick()
                        }}>
        Reset
    </button>);
};
ResetButton.propTypes = {
    onClick: PropTypes.func.isRequired
};
export default ResetButton;