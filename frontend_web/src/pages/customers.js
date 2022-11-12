import * as React from "react"
import Layout from "../components/layout"
import "../components/styles/global.css"
import { useAuth0 } from "@auth0/auth0-react"

const Customers = () => {
	const { isAuthenticated } = useAuth0()
	return (
		<Layout>
			{!isAuthenticated && (
				<h1>Please login to view this page's contents</h1>
			)}
			{isAuthenticated && (
				<h1>You have logged in and can view this page!</h1>
			)}
		</Layout>
	)
}

export default Customers
