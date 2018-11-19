import React, {Component} from "react";
import RollButtons from "./RollButtons";
import ScoreBoard from "./ScoreBoard";
import ResetButton from "./NewGame";
import "@babel/polyfill";
import img from "./logo.png"

import "./App.css";

const initialState = {
    rolls: [],
    scores: [],
    sum: 0,
    pinsDown: 0,
    firstRoll: true
};

let getScoreForRolls = async function (rolls) {
    return Promise.resolve(await fetch('/v1/score-calculation/by-game', {
        method: 'post',
        headers: {
            "Content-Type": "application/json; charset=utf-8",
        },
        body: JSON.stringify(rolls)
    }).then((resp) => {
        return resp.json()
    }));
};

class App extends Component {
    constructor(props, context) {
        super(props, context);

        this.onRoll = this.onRoll.bind(this);
        this.onReset = this.onReset.bind(this);

        this.state = initialState
    }

    onReset() {
        this.setState(initialState)
    }

    onRoll(number) {
        const newRolls = [number];
        let pinsDown = 0;
        let nextRollState = !this.state.firstRoll;

        if (this.state.firstRoll) {
            if (number == 10)
                nextRollState = true;
            else
                pinsDown = number;
        }
        this.setState({
            rolls: [...this.state.rolls, ...newRolls],
            pinsDown: pinsDown,
            firstRoll: nextRollState
        }, function afterRollsUpdate() {
            getScoreForRolls(this.state.rolls).then((value => {
                this.setState({scores: value.scores, sum: value.sum})
            }));
        });
    };

    render() {
        return (
            <div>
                <nav className="navbar navbar-expand-lg navbar-dark bg-dark static-top">
                    <div className="container-fluid">
                        <div className="navbar-header">
                            <img src={img} alt="Logo" className="img-thumbnail"/>
                        </div>
                        <span className="display-4 text-white">
                           Bowling Game Scorer
                        </span>
                    </div>
                </nav>
                <div className="control-buttons-tab">
                    <RollButtons onClick={this.onRoll} pinsDown={this.state.pinsDown}/>
                    <ResetButton onClick={this.onReset}/>
                </div>
                <ScoreBoard rolls={this.state.rolls} scores={this.state.scores} sum={this.state.sum}/>
            </div>
        );
    }
}

export default App;
