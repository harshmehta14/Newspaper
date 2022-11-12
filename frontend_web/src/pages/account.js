import React from "react"
import { useAuth0 } from "@auth0/auth0-react"
import Layout from "../components/layout"
import { alert } from "../components/styles/layout.module.css"

const Account = () => {
	/* Access user from the useAuth0 hook */
	const { user, isAuthenticated } = useAuth0()
	return (
		<Layout>
			{!isAuthenticated && (
				<h1 className={alert}>Please login to view the page</h1>
			)}
			{isAuthenticated && <p>Email: {user.email}</p>}
		</Layout>
	)
}

export default Account
