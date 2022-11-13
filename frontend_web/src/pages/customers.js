import * as React from "react"
import Layout from "../components/layout"
import "../components/styles/global.css"
import { useAuth0 } from "@auth0/auth0-react"
import { alert } from "../components/styles/layout.module.css"
import { useState } from "react"
import Create from "../components/create"

const Customers = () => {
	const [display, setDisplay] = useState(false)
	const HandleDisplay = () => {
		setDisplay(!display)
	}
	const { isAuthenticated } = useAuth0()
	return (
		<Layout>
			{!isAuthenticated && (
				<h1 className={alert}>
					Please login to view this page's contents
				</h1>
			)}
			{isAuthenticated && (
				<>
					{/* <h1>You have logged in and can view this page!</h1> */}
					<button class="btn btn-info" onClick={HandleDisplay}>Add customers</button>
					{display && <Create />}
					<table class="table table-striped">
					<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">Name</th>
						<th scope="col">Email</th>
						<th scope="col">Phone No</th>
						<th scope="col">Address</th>
					</tr>
					</thead>
					<tbody>
					<tr>
						<th scope="row">1</th>
						<td>John Mathew</td>
						<td>johnmathew12@gmail.com</td>
						<td>+91789436955</td>
						<td>Belahali cross, Banagalore</td>
					</tr>
					<tr>
						<th scope="row">2</th>
						<td>Sanjay</td>
						<td>sanjayverma@gmail.com</td>
						<td>+918794521365</td>
						<td>Hebbal, Bangalore</td>
					</tr>
				
					</tbody>
					</table>
				
				
				</>
			)}
		</Layout>
	)
}

export default Customers
