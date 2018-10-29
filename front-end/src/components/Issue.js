import React from 'react';

import './Issue.css';

const issue = (props) => (
    <section className="Issue">
        <h1>{props.title}</h1>
        <p>{props.body}</p>
        <p><b>User login:</b> {props.user}</p>
        <p><b>Assignee:</b> {props.assignee}</p>
    </section>
);

export default issue;