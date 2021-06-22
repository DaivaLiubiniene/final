import React, { Component } from "react";
import axios from "axios";

export default class ClientListComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      clients: [],
    };
    this.refreshCourses = this.refreshCourses.bind(this);
  }

  componentDidMount() {
    this.refreshCourses();
  }

  refreshCourses() {
    axios.get("http://localhost:8080/api/clients").then((response) => {
      console.log(response);
      this.setState({ clients: response.data });
    });
  }

  render() {
    return (
      <div className="container">
        <h2>Klientai</h2>
        <div className="container">
          <table className="table">
            <thread>
              <tr>
                <th>Vardas</th>
                <th style={{ width: 200 }}>Pavardė</th>
                <th style={{ width: 200 }}>Gimimo data</th>
                <th style={{ width: 200 }}>Telefono numeris</th>
                <th style={{ width: 200 }}>Kliento tipas</th>
              </tr>
            </thread>
            <body>
              {this.state.clients.map((client) => (
                <tr key={client.id}>
                  <td>{client.name}</td>
                  <td>{client.surname}</td>
                  <td>{client.birthdate}</td>
                  <td>{client.phone}</td>
                  <td>{client.type}</td>
                </tr>
              ))}
            </body>
          </table>
        </div>
      </div>
    );
  }
}
