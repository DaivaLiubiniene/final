import React, { Component } from "react";
import axios from "axios";

export default class YearsList extends Component {
  constructor(props) {
    super(props);
    this.state = {
      years: [],
    };
    this.refreshClients = this.refreshClients.bind(this);
  }

  componentDidMount() {
    this.refreshClients();
  }

  refreshClients() {
    axios.get("/api/clients").then((response) => {
      console.log(response);
      this.setState({ clients: response.data });
    });
  }
  render() {
    return (
      <div className="container">
        <h3>Clients</h3>
        <table className="table">
          <thread>
            <tr>
              <th>Vardas</th>
              <th>Pavardė</th>
              <th>Gimimo data</th>
              <th>Telefono numeris</th>
              <th>Kliento tipas</th>
              <th>&nbsp;</th>
            </tr>
          </thread>
          {this.state.clients.map((client, index) => {
            return (
              <tr key={index}>
                <td>{client.name}</td>
                <td>{client.surname} </td>
                <td>{client.birthdate} </td>
                <td>{client.type} </td>
                <td>
                  <a href="#0">Add</a>
                </td>
              </tr>
            );
          })}
        </table>
      </div>
    );
  }
}