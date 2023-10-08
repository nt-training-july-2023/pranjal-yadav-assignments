import React from 'react'

const CustomButton = ({text, style, onClick}) => {
  return (
   
        <button className={`custom-button ${style}`}
        onClick={onClick}> 
        {text}
        </button>
    
  )
}

export default CustomButton