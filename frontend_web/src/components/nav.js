import * as React from "react"
import styled from "styled-components"
import { useState } from "react"
import { Link } from "gatsby"
import {
	bar,
	ham,
	innerlinks,
	active,
	align,
} from "../components/styles/nav.module.css"
import classNames from "classnames"

const Pagelinks = styled.nav`
	padding: 0.7rem 1.5rem;
	background-color: var(--c1);

	ul {
		margin: 0;
		display: flex;
		gap: 3rem;
		align-items: center;
		justify-content: center;
		list-style: none;
		padding: 0;
	}

	ul a {
		text-decoration: none;
		color: var(--c3);
		font-size: 1.3rem;
		font-weight: 800;
	}

	@media (max-width: 850px) {
		display: flex;
		justify-content: space-between;
	}
`

export default function Nav() {
	const [toggle, setToggle] = useState(false)

	const handleToggle = () => {
		setToggle(!toggle)
	}

	const active_links = classNames(innerlinks, active)
	const active_ham = classNames(ham, active)

	return (
		<Pagelinks>
			<div
				className={toggle ? active_ham : ham}
				onClick={handleToggle}
				role="navigation">
				<span className={bar}></span>
				<span className={bar}></span>
				<span className={bar}></span>
			</div>
			<ul
				ul
				className={toggle ? active_links : innerlinks}
				onClick={handleToggle}
				role="navigation">
				<li>
					<Link to="/">Home</Link>
				</li>
				<li>
					<Link to="/account">Account</Link>
				</li>
				<li>
					<Link to="/customers">Customers</Link>
				</li>
				<li>
					<Link to="/paperboys">Paperboys</Link>
				</li>
				<li>
					<Link to="/distribution">Distribution</Link>
				</li>
			</ul>
			<div className={align}></div>
		</Pagelinks>
	)
}
