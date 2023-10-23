import React, { useEffect } from 'react'
import './Unassign.css'
import { useNavigate, useParams } from 'react-router-dom'
import axios from 'axios';
import AdminService from '../../service/AdminService';
import CustomButton from '../CustomButton';

const UnassignProject = () => {
  const {id} = useParams();
  const navigate = useNavigate();
  useEffect(() => {
    getAllProjects();
  }, []);
  const getAllProjects = ()=>{
  }
  const respondToYes = () =>{
    try{
  
     AdminService.unassign(id).then((response) =>{
      navigate("/adminDashboard")
    })
  }
    catch(error){
    }
  }
  const respondToNo = () =>{
    navigate("/adminDashboard")
  }

  return (
    <div className='unassign_div'>
        <h3 className='unassign_question'>Are you sure to unassign project to this employee?</h3>
        <CustomButton text={"Yes"} style="answer_yes" onClick={respondToYes}/>
        <CustomButton text={"No"} style="answer_no" onClick={respondToNo}/>
    </div>
  )
}

export default UnassignProject
