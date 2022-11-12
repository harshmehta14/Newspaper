import * as React from "react"
import Layout from "../components/layout"
import "../components/styles/global.css"
import styled from "styled-components"

const MainContainer = styled.div`
	display: flex;
	gap: 1rem;
	height: 20rem;

	> section {
		padding: 1rem;
	}
`

const Sidesection = styled.section`
	flex-basis: 25%;
`

const Midsection = styled.section`
	flex-basis: 50%;
	border-left: 0.8px dotted var(--c2);
	border-right: 0.8px dotted var(--c2);
`

const IndexPage = () => {
	return (
		<Layout>
			<MainContainer>
				<Sidesection>content</Sidesection>
				<Midsection>content sdfsadfdsf</Midsection>
				<Sidesection>content</Sidesection>
			</MainContainer>
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
