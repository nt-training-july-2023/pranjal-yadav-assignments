import React from 'react';
import "../UnauthorizedAccess/UnauthorizedAccess.css"

const UnauthorisedAccess = () => {
  return (
    <div className="unauthorized-container">
      <div class="warning-symbol">&#9888;</div>

      <h1>Unauthorized Access</h1>
      <p>You do not have permission to access this page.</p>
      <p>
        <a href="/">Return to the homepage</a>
      </p>
    </div>
  );
}

export default UnauthorisedAccess