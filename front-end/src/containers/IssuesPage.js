import React, { Component } from 'react';
import axios from 'axios';

import Issue from '../components/Issue';
import './IssuesPage.css';

class IssuesPage extends Component {
    
    state = {
      issues: []
    }

    componentDidMount() {
      axios.get('https://api.github.com/repos/angular/angular/issues')
      .then(response => {
        this.setState({ issues: response.data });
        console.log(response);
      })
    }

    render () {

        const issues = this.state.issues.map(issue => {
            return <Issue 
                  key={issue.number} 
                  title={issue.title}
                  body={issue.body}
                  user={issue.user.login}/>
          }
        );

        return (
            <div>
                {issues}
            </div>
        );
    }
}

export default IssuesPage;