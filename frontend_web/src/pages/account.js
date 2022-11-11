import React from "react"
import { Link } from "gatsby"
import { useAuth0 } from "@auth0/auth0-react"
/* Import the withAuthenticationRequired HOC */
import { withAuthenticationRequired } from "@auth0/auth0-react"
import LogoutButton from "../components/LogoutButton"
import Layout from "../components/layout"

const Account = () => {
	/* Access user from the useAuth0 hook */
	const { user } = useAuth0()
	return (
		<Layout>
			<p>Email: {user.email}</p>
			<LogoutButton />
		</Layout>
	)
}

/*  Wrap the component in the withAuthenticationRequired handler  */
export default withAuthenticationRequired(Account)
