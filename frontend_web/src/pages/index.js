import * as React from "react"
import Layout from "../components/layout"
import "../components/styles/global.css"
import styled from "styled-components"
import homepage from "../images/news.jpeg"

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

  h3{
    margin-top: 0;
    font-size: 2rem;
	margin-bottom: 0;
  }
 p{
	font-size: 1.3rem
 }
  ul {
	padding-left: 0.8rem;
  }

  ul li{
	font-size: 1.1rem;
  }
`

const Midsection = styled.section`
	flex-basis: 50%;
	border-left: 0.8px dotted var(--c2);
	border-right: 0.8px dotted var(--c2);
	min-height: 27rem;

  h2{
    text-align:center;
    border: 0.3px solid var(--c2);
    margin-top: 0;
	font-size: 2.1rem;
  }
  img{
	margin:0 6rem;
  }
`

const IndexPage = () => {
	return (
		<Layout>
			<MainContainer>
				<Sidesection><h3>The problem</h3>
				<p>Despite all the advancements in technology, the supply chain for newsapers is quite outdated. The biggest problem is the lack of proper communication between the distributer and customer. New customers find it hard to contact a supplier for a subscription.</p>
        		<p>Problems faced by the customer:
					<ul>
						<li>Difficulty in finding a supplier in the locality</li>
						<li>Lack of a reminder for when payments should be made</li>
						<li>Lack of communication with the supplier</li></ul></p>
						{/* <p>Problems faced by the paperboys and suppliers:
							<ul>
								<li></li>
							</ul>
						</p> */}
						</Sidesection>
				<Midsection><h2>What we hope to accomplish</h2>
				<img src={homepage} height="90%" width="70%"/>
        </Midsection>
				<Sidesection><h3>Contact</h3></Sidesection>
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
