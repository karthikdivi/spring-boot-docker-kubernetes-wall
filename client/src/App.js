import React, { Component } from 'react'

import TimeAgo from 'javascript-time-ago'
 
// Load locale-specific relative date/time formatting rules.
import en from 'javascript-time-ago/locale/en'

import logo from './logo.svg';
import './App.css';

TimeAgo.addLocale(en);
const timeAgo = new TimeAgo('en-US')

class App extends Component {

  state = {
    message : null,
    messages: []
  }

  async componentWillMount(){
    let res = await fetch('/wall');
    let json = await res.json();
    if(json){
      this.setState({messages: json.reverse()});
    }

  }

  handleChange = e => {
    console.log(e.target.value);
    this.setState({message: e.target.value})
  }

  handleSubmit = async () => {
    console.log('submitting');
    if(this.state.message){
      let res = await fetch('/wall', {
        method: 'POST',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({
          text: this.state.message
        })
      });
      let json = await res.json();
      if(json){
        this.setState({messages: json.reverse()});
      }
    }
  };

  render(){

    const messagesData = this.state.messages.map(ele => 
    <div className="message-card" key={ele.date}>
      <p className="message-card-text">
        {ele.text}
      </p>
      <sub className="message-card-sub-text">
        {timeAgo.format(ele.date)}
      </sub>
      <hr/>
    </div>);

    return (
      <>
      <div id="cover">
          <div className="tb">
            <div className="td"><input type="text" placeholder="Write something " required  onChange={this.handleChange} 
            onKeyPress={event => {
              if (event.key === 'Enter') {
                this.handleSubmit()
              }
            }}
            /></div>
            <div className="td" id="s-cover">
              <button onClick={this.handleSubmit}>
                <div id="s-circle"></div>
                <span></span>
              </button>
            </div>
          </div>  
      </div>
      <br/><br/><br/><br/>
      <div className="cards">
        <h3>IDC Wall</h3>
        {messagesData}
      </div>
      </>
    );
  }
}


export default App;
