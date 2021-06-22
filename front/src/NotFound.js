import React from "react";
import { Link } from "react-router-dom";

const NotFound = () => {
  return (
    <div>
      <p className="ml-2">Page not found</p>
      <Link to="/" className="btn btn-primary ml-2">
        HomePage
      </Link>
    </div>
  );
};

export default NotFound;