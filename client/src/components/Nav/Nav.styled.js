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
  > a {
    display: flex;
    align-items: center;
  }

  .link-withIcon {
    padding: 8px 6px 8px 8px;
  }

  > a svg {
    margin-right: 6px;
    color: hsl(210, 8%, 55%);
  }

  &.nav-selected {
    background-color: hsl(210, 8%, 95%);
    border-right: 3px solid hsl(27, 90%, 55%);

    a svg {
      color: hsl(210, 8%, 5%);
    }

    h2 {
      color: hsl(210, 8%, 5%);
      font-weight: bold;
    }
  }
`;

export const Text = styled.h2`
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

  &.nav-list:hover {
    color: hsl(210, 8%, 15%);
  }

  &.nav-list-padding {
    padding: 4px;
    padding-left: 30px;
    line-height: 2;
  }
`;
