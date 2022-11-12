import React from "react"
import { useAuth0 } from "@auth0/auth0-react"
import Layout from "../components/layout"
import { alert } from "../components/styles/layout.module.css"
import styled from "styled-components"

const UserInfo = styled.div`
	margin: -10rem auto;
	width: 30rem;

	span {
		display: inline-block;
		border: 0.1rem solid var(--c2);
		border-radius: 3rem;
		padding: 0.3rem 1rem;
	}
`

const Account = () => {
	/* Access user from the useAuth0 hook */
	const { user, isAuthenticated } = useAuth0()
	return (
		<Layout>
			{!isAuthenticated && (
				<h1 className={alert}>Please login to view the page</h1>
			)}
			{isAuthenticated && (
				<UserInfo>
					<h2>Welcome User!</h2>
					<p>
						Name: <span>placeholder Name here</span>
					</p>
					<p>
						Email address: <span>{user.email}</span>
					</p>
					<p>
						Address: <span>placeholder address here</span>
					</p>
				</UserInfo>
			)}
		</Layout>
	)
}

export default Account
