import React, { Component } from 'react';

import './IssueDetails.css';

class Issue extends Component {
    render () {
        let post = <p>Please select a Post!</p>;
        post = (
            <div className="IssueDetails">
                <h1>{props.number}</h1>
                <p>Content</p>
                <div className="Edit">
                    <button className="Delete">Delete</button>
                </div>
            </div>

        );
        return post;
    }
}

export default IssueDetails;