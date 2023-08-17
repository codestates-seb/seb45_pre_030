import styled from 'styled-components';

export const Container = styled.nav`
  position: sticky;
  overflow-y: auto;
  top: 56px;
  margin-bottom: 8px;
  width: 164px;
  max-height: calc(100vh - 56px);
`;

export const NavContainer = styled.ul``;

export const NavWrapper = styled.li`
  &.wrapper-withIcon {
    padding: 8px 6px 8px 8px;
  }

  > a {
    display: flex;
    align-items: center;
  }

  > a svg {
    margin-right: 6px;
    color: hsl(210, 8%, 55%);
  }
`;

export const Text = styled.h2`
  width: auto;
  &.nav-group {
    font-size: 11px;
    margin: 16px 0 4px 8px;
    color: hsl(210, 8%, 45%);
    line-height: 2;
  }

  &.nav-list {
    font-size: 13px;
    color: hsl(210, 8%, 35%);
  }

  &.nav-list-padding {
    padding: 4px;
    padding-left: 30px;
    line-height: 2;
  }
`;
