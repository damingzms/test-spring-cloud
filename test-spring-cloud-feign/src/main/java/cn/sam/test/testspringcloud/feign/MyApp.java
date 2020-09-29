package cn.sam.test.testspringcloud.feign;

import java.util.List;

import feign.Feign;
import feign.Param;
import feign.RequestLine;
import feign.jackson.JacksonDecoder;

public class MyApp {
	
	public static void main(String... args) {
		GitHub github = Feign.builder().decoder(new JacksonDecoder()).target(GitHub.class, "https://api.github.com");

		// Fetch and print a list of the contributors to this library.
		List<Contributor> contributors = github.contributors("OpenFeign", "feign");
		for (Contributor contributor : contributors) {
			System.out.println(contributor.login + " (" + contributor.contributions + ")");
		}
		
		contributors = github.contributors("OpenFeign22", "feign");
		for (Contributor contributor : contributors) {
			System.out.println(contributor.login + " (" + contributor.contributions + ")");
		}
	}

	public static interface GitHub {
		@RequestLine("GET /repos/{owner:[a-zA-Z]*}/{repo}/contributors")  // 限制owner只能包含字母字符
		List<Contributor> contributors(@Param("owner") String owner, @Param("repo") String repo);

		@RequestLine("POST /repos/{owner}/{repo}/issues")
		void createIssue(Issue issue, @Param("owner") String owner, @Param("repo") String repo);

	}

	public static class Contributor {
		String login;
		int contributions;
	}

	public static class Issue {
		String title;
		String body;
		List<String> assignees;
		int milestone;
		List<String> labels;
	}
	
}