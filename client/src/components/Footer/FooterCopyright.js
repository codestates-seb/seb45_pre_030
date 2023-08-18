import { CopyDiv, CopyUl, CopyLi, Text } from './Footer.styled';

function Copyright() {
  return (
    <CopyDiv>
      <CopyUl>
        <CopyLi>Blog</CopyLi>
        <CopyLi>Facebook</CopyLi>
        <CopyLi>Twitter</CopyLi>
        <CopyLi>LinkedIn</CopyLi>
        <CopyLi>Instagram</CopyLi>
      </CopyUl>
      <Text>
        Site design / logo © 2023 Stack Exchange Inc; user contributions
        <br />
        licensed under CC BY-SA. rev 2023.8.10.43574
      </Text>
    </CopyDiv>
  );
}

export default Copyright;
