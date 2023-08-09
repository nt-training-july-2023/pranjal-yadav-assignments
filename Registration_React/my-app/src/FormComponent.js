
import React from 'react'

export default function FormComponent() {
  return (
    <div class="main">

        <div class="heading">
            Registration form
        </div>
        <div >
          <hr class="line" />
        </div>

        <div class="form">
            <form>
                <div class="user">

                
                    <div class="input">
                        <span class="details">Full Name</span>
                        <input type="text" placeholder="Enter your name" required />
                    </div>

                   
                    <div class="input">
                        <span class="details">User Name</span>
                        <input type="text" placeholder="Enter your name" required />
                    </div>

                    
                    <div class="input">
                        <span class="details">Email</span>
                        <input type="email" placeholder="Enter your name" required/>
                    </div>

                   
                    <div class="input">
                        <span class="details">Phone number</span>
                        <input type="text" placeholder="Enter your name" required />
                    </div>

                   
                    <div     class="input">
                        <span class="details">Password</span>
                        <input type="password" placeholder="Enter your name" required />
                    </div>

                 
                    <div class="input">
                        <span class="details">Confirm password</span>
                        <input type="password" placeholder="Enter your name" required />
                    </div>
                </div>

                <div class="gender">
                    <input type="radio" name="gender" id="dot-1" />
                    <input type="radio" name="gender" id="dot-2" />
                    <input type="radio" name="gender" id="dot-3" />
                    <span class="gender-title">Gender</span>
                    <div class="category">
                        <label for="dot-1">
                            <span class="dot one"></span>
                            <span class="gender">Female</span>
                        </label>
                        <label for="dot-2">
                            <span class="dot two"></span>
                            <span class="gender">Male</span>
                        </label>
                        <label for="dot-3">
                            <span class="dot three"></span>
                            <span class="gender">Prefer not to say</span>
                        </label>

                    </div>
                </div>

                <div class="button">
                    <input type="submit" value="Register" formaction="submit.html" />
                </div>
            </form>
        </div>
    </div>
  )
}


  