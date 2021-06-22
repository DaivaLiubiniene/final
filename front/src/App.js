import React, { Component } from "react";
import { Switch, Route } from "react-router-dom";
import NavBar from "./NavigationComponent";
import NotFound from "./NotFound";
import HolidaysList from "./ClientList";
import CountriesList from "./CountriesList";
import YearsList from "./YearsList";

export default class App extends Component {
  render() {
    return (
      <div className="container">
        <NavBar />
        <Switch>
          <Route exact path="/" component={ClientList} />
          <Route path="/inventory" component={CountriesList} />
          <Route path="*" component={NotFound} />
          <Route component={NotFound} />
        </Switch>
      </div>
    );
  }
}
