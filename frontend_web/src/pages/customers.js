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
					<h1>You have logged in and can view this page!</h1>
					<button onClick={HandleDisplay}>Add customers</button>
					{display && <Create />}
				</>
			)}
		</Layout>
	)
}

export default Customers
