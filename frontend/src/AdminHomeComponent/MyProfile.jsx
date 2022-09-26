import React from 'react'
import axios from "axios"
import { useEffect, useState } from "react"
import { useHistory } from "react-router"

export default function MyProfile(props) {
    const history = useHistory()
    const userId = props.location.aboutProps.id.user
    const url = "http://localhost:8080"

    useEffect(() =>{
        getProfile()
    },[])

    const getProfile = () =>{
        const body ={
            "userid" : userId
        }
        console.log("userid : "+userId )

        axios.post(url+"/api/v1/user/myprofile",body).then(Response =>{
            const result = Response.data
            if(result.status == "success"){
                history.push({
                    pathname:'/userProfile',
                    search:'?query=abc',
                    state: result.user
                })
            }
        })

    }

  return (
    <div></div>
  )

}