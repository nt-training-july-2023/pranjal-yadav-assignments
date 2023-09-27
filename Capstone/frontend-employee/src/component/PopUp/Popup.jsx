import React from 'react'
import './PopUp.css'

const Popup = ({message ,onClose, showAcceptButton, onAccept}) => {
  return (
    // <div className="popup">
    //         <div className="popup-content">
    //             <p>{message}</p>
    //             <button onClick={onClose}>Close</button>
    //         </div>
    //     </div>
    <div className="popup">
            <div className="popup-content">
                <p className="popup-message">{message}</p>
                <div className="btn_popup">
                <button className="close_popup" onClick={onClose}>Close</button>
                {showAcceptButton && (
                    <button className="accept-button" onClick={onAccept}>Accept</button>
                )}
                </div>
               
            </div>
        </div>
  )
}

export default Popup