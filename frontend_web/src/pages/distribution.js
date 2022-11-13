import * as React from "react"
import Layout from "../components/layout"
import "../components/styles/global.css"
import { useAuth0 } from "@auth0/auth0-react"
import { alert } from "../components/styles/layout.module.css"

const Distribution = () => {
	const { isAuthenticated } = useAuth0()
	return (
		<Layout>
			{!isAuthenticated && (
				<h1 className={alert}>
					Please login to view this page's contents
				</h1>
			)}
			{isAuthenticated && (
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
					<td>Vijay</td>
					<td>vijayverma@gmail.com</td>
					<td>+917891234533</td>
					<td>Bhartiya City, Thanisandra main road, R K Hegde Nagar, Bangalore 560077</td>
				</tr>
				<tr>
					<th scope="row">2</th>
					<td>Shekar</td>
					<td>Shekargowda@gmail.com</td>
					<td>+918794511165</td>
					<td>Yelahanka, Bangalore</td>
				</tr>
			
				</tbody>
				</table>
			
			)}
		</Layout>
	)
}

export default Distribution
