import * as React from "react"
import { Link } from "gatsby"
import Layout from "../components/layout"
import icon from "../images/icon.png"
import LoginButton from "../components/LoginButton"

const IndexPage = () => {
	return (
		<Layout>
			<p>welcome to this site!</p>
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
		<meta
			name="image"
			content={icon}
		/>
	</>
)
