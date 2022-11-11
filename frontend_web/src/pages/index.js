import * as React from "react"
import { Link } from "gatsby"
import Layout from "../components/layout"
import "../components/styles/global.css"
import LoginButton from "../components/LoginButton"
import { useAuth0 } from "@auth0/auth0-react"

const IndexPage = () => {
	const { isAuthenticated } = useAuth0()
	return (
		<Layout>
			<p>welcome to this site!</p>
			{isAuthenticated && (
				<p>you will see this only if you are authenticated</p>
			)}
			{!isAuthenticated && (
				<p>you will see this only if you arent authenticated</p>
			)}
			<Link to="/account">account page</Link>
			<LoginButton />
		</Layout>
	)
}

export default IndexPage

export const Head = () => (
	<>
		<title>Home Page</title>
		<meta
			name="keywords"
			content="newspaper app"
		/>
	</>
)
