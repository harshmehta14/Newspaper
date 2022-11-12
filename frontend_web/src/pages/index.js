import * as React from "react"
import Layout from "../components/layout"
import "../components/styles/global.css"

const IndexPage = () => {
	return (
		<Layout>
			<p>welcome to this site!</p>
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
