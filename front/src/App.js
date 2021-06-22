import React, { Component } from "react";
import NavBar from "./NavBar";
import ClientList from "./ClientListComponent";

export default class App extends Component {
  render() {
    return (
      <div>
        <NavBar />
        <ClientList />
      </div>
    );
  }
}
