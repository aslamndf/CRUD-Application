import React from "react";
import { Link } from "react-router-dom";

export default function Navbar() {
  return (
    <>
      <nav className="navbar navbar-expand-lg bg-primary">
        <div className="container-fluid">
          <a className="navbar-brand" href="#">
            CRUD Application
          </a>
          <Link className="btn btn-outline-light" to="/addUser">Add User</Link>
        </div>
      </nav>
    </>
  );
}
