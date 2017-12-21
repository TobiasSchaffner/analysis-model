package edu.hm.hafner.analysis.parser;

import edu.hm.hafner.analysis.AbstractParser;
import edu.hm.hafner.analysis.AbstractParserTest;
import edu.hm.hafner.analysis.Issue;
import edu.hm.hafner.analysis.Issues;
import edu.hm.hafner.analysis.Priority;
import edu.hm.hafner.analysis.assertj.SoftAssertions;

/**
 * Tests the class {@link TnsdlParser}.
 */
public class TnsdlParserTest extends AbstractParserTest {
    public TnsdlParserTest() {
        super("tnsdl.txt");
    }

    @Override
    protected AbstractParser createParser() {
        return new TnsdlParser();
    }

    @Override
    protected void assertThatIssuesArePresent(final Issues<Issue> issues, final SoftAssertions softly) {
        softly.assertThat(issues).hasSize(4);

        softly.assertThat(issues.get(0))
                .hasPriority(Priority.NORMAL)
                .hasCategory(TnsdlParser.WARNING_CATEGORY)
                .hasLineStart(398)
                .hasLineEnd(398)
                .hasMessage("unused variable sender_pid")
                .hasFileName("tstmasgx.sdl");
        softly.assertThat(issues.get(1))
                .hasPriority(Priority.HIGH)
                .hasCategory(TnsdlParser.WARNING_CATEGORY)
                .hasLineStart(399)
                .hasLineEnd(399)
                .hasMessage("unused variable a_sender_pid")
                .hasFileName("tstmasgx.sdl");
        softly.assertThat(issues.get(2))
                .hasPriority(Priority.NORMAL)
                .hasCategory(TnsdlParser.WARNING_CATEGORY)
                .hasLineStart(3)
                .hasLineEnd(3)
                .hasMessage("Id. length is reserved in PL/M 386 intrinsics")
                .hasFileName("s_dat:dty0132c.sdt");
        softly.assertThat(issues.get(3))
                .hasPriority(Priority.HIGH)
                .hasCategory(TnsdlParser.WARNING_CATEGORY)
                .hasLineStart(4)
                .hasLineEnd(4)
                .hasMessage("Id. length is reserved in PL/M 386 intrinsics")
                .hasFileName("s_dat:dty0132c.sdt");
    }
}
