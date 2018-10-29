import React, { Component } from 'react';

// imported frameworks
import axios from 'axios';
import {JsonTable} from 'react-json-to-html';

// custom components
import Button from './components/Button.js';

class App extends Component {
  
  constructor() {
    super();
    
    this.state = {
      info: '',
      issues: []
    }

    this.handleClick = this.handleClick.bind(this)
  }
  
  handleClick(e) {
      axios.get('https://api.github.com/repos/angular/angular/issues')
      .then(response => this.setState({
        info : JSON.stringify(response.data, undefined, 2)
      }));
  }

  componentDidMount() {
    axios.get('https://api.github.com/repos/angular/angular/issues')
    .then(response => {
      var issues = response.data;
      this.setState({ issues });
    })
    .catch(error => console.log('error:', error));
  }

  render() {
    return (
      <div className="App">
        <header className="App-header">
          <h1 className="App-title">Angular Repository Issues</h1>
        </header>
        <p className="App-intro">
          Watch this space...
        </p>
        
        <ul>
          { this.state.issues.map(issue => 
              <li>
                {issue.number}
                {issue.title} 
                {issue.user.login}
                {issue.assignee}
              </li>
          )}
        </ul>
        {/*
        <Button handleClick={this.handleClick}/>
        <p><b>Information:</b></p>
        <pre>{this.state.info}</pre>
        */}
        
      </div>
    );
  }
}
export default App;