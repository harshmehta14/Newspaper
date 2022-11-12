/**
 * @type {import('gatsby').GatsbyConfig}
 */
module.exports = {
	siteMetadata: {
		title: `Newspaper`,
		siteUrl: `https://www.yourdomain.tld`,
	},
	plugins: [
		{
			resolve: "gatsby-plugin-manifest",
			options: {
				icon: "./src/images/logo.jpeg", // Relative to the project's root folder
			},
		},
		"gatsby-plugin-styled-components",
	],
}
