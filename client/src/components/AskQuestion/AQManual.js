import { ManualBox, DivH1, DivH2, DivH5, Ul, Li } from './AQ.styled';

function Manual() {
  return (
    <ManualBox>
      <DivH1>Writing a good question</DivH1>
      <DivH2>
        You’re ready to ask a programming-related question and this form will
        help guide you through the process.
        <br />
        Looking to ask a non-programming question? See the topics here to find a
        relevant site.
      </DivH2>
      <DivH5>Steps</DivH5>
      <Ul>
        <Li>Summarize your problem in a one-line title.</Li>
        <Li>Describe your problem in more detail.</Li>
        <Li>Describe what you tried and what you expected to happen.</Li>
        <Li>
          Add “tags” which help surface your question to members of the
          community.
        </Li>
        <Li>Review your question and post it to the site.</Li>
      </Ul>
    </ManualBox>
  );
}

export default Manual;
