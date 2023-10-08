import React from 'react'

const InputComponent = ({type, placeholder, value, onChange, className, onBlur, id}) => {
  return (
    <input
    id={id} 
    type={type}
    placeholder={placeholder}
    value={value}
    onChange={onChange}
    onBlur={onBlur}
    className={className}
    />
  )
}

export default InputComponent