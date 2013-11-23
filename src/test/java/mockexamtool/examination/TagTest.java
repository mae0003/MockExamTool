package mockexamtool.examination;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class TagTest {

	@Test
	public void コンストラクタ_親タグなし() {
		int id = 1;
		String name = "システム開発";
		Tag target = new Tag(id, name);

		assertThat(target.getId(), is(id));
		assertThat(target.getName(), is(name));
		assertThat(target.isTopLevel(), is(true));
	}

	@Test
	public void コンストラクタ_親タグあり() {
		int parentId = 1;
		String parentName = "システム開発";
		Tag parent = new Tag(parentId, parentName);

		int id = 2;
		String name = "プログラミング";
		Tag target = new Tag(id, name, parent);

		assertThat(target.getId(), is(id));
		assertThat(target.getName(), is(name));
		assertThat(target.isTopLevel(), is(false));
		assertThat(target.getParent(), is(parent));
	}

	@Test
	public void getChildren() {
		int id = 1;
		String name = "システム開発";
		Tag target = new Tag(id, name);

		int childId1 = 2;
		String childName1 = "プログラミング";
		Tag child1 = new Tag(childId1, childName1, target);

		int childId2 = 3;
		String childName2 = "テスト";
		Tag child2 = new Tag(childId2, childName2, target);

		List<Tag> children = target.getChildren();
		assertThat(children.size(), is(2));
		assertThat(children.contains(child1), is(true));
		assertThat(children.contains(child2), is(true));
	}

}
