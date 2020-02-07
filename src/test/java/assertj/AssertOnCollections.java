package assertj;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class AssertOnCollections {

	List<Character> chessPieces;
	Character char1;
	Character char2;
	Character char3;

	@BeforeEach
	void init() {

		char1 = new Character("A", "Pawn");
		char2 = new Character("B", "King");
		char3 = new Character("C", "Bishop");

		chessPieces = Arrays.asList(char1, char2, char3);
	}

	@Test
	void oneElementExists() {

		assertThat(chessPieces).contains(char1);
	}

	@Test
	void selectedElementsExist() {

		assertThat(chessPieces).contains(char1, char3);
	}

	@Test
	void selectedElementsExistAnyOrder() {

		assertThat(chessPieces).containsExactlyInAnyOrder(char1, char3, char2);
	}

	@Test
	void selectedElementsExistSpecificOrder() {

		assertThat(chessPieces).containsExactly(char1, char2, char3);
	}

	@Test
	void selectedElementsExistOnlyOnce() {

		assertThat(chessPieces).containsOnlyOnce(char1);
	}

	//failing to show error..add missing to pass
	@Test
	void selectedElementsExtractingProperty() {

		assertThat(chessPieces)
				.extracting(Character::getName)
				.containsExactly("Pawn");
	}

	@Test
	void collectionsLotsOfStuff() {

		assertThat(chessPieces)
				.hasSize(3)
				.doesNotHaveDuplicates()
				.contains(char1)
				.endsWith(char3)
				.startsWith(char1);
	}

	@Test
	void assertCollectionsWithFilter() {

		assertThat(chessPieces)
				.filteredOn(character -> character.getName().contains("Pawn"))
				.contains(char1);

	}

	@Getter
	@RequiredArgsConstructor
	private static class Character {

		private final String Id;
		private final String name;
	}
}