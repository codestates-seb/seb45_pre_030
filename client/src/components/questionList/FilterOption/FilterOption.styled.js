import styled from 'styled-components';

export const Container = styled.div`
  display: flex;
  flex-direction: column;
  width: 100%;
  background-color: hsl(210, 8%, 95%);
  border: 1px solid hsl(210, 8%, 85%);
  margin-bottom: 16px;
  border-radius: 4px;
  overflow: hidden;

  &.hide {
    display: none;
  }
`;

export const SubContainer = styled.div`
  display: flex;
  width: 100%;

  &:not(:first-of-type) {
    justify-content: space-between;
    border-top: 1px solid hsl(210, 8%, 85%);
    padding: 12px;
  }
`;

export const Wrapper = styled.div`
  display: flex;
  flex-direction: column;
  margin: 16px;
`;

export const Title = styled.h3`
  font-size: 1rem;
  font-weight: 600;
  margin-bottom: 6px;
`;

export const OptionWrapper = styled.div`
  display: flex;
  margin: 6px 0;
`;

export const Input = styled.input`
  margin: 0 2px;
  border: 1px solid hsl(210, 8%, 75%);
  border-radius: 4px;
  font-size: 13px;

  &.tag-editor {
    border-style: none;
    padding-left: calc(0.7em - 2px);
    background-color: initial;
    margin: 5px 0;
  }

  &.hide {
    display: none;
  }

  &::placeholder {
    color: hsl(210, 8%, 75%);
  }

  &:focus {
    outline: none;
  }
`;

export const Option = styled.p`
  margin: 0 4px;
  font-size: 1rem;
  white-space: nowrap;
`;

export const TagContainer = styled.div`
  display: flex;
  border: 1px solid hsl(210, 8%, 75%);
  border-radius: 6px;
  background-color: hsl(0, 100%, 100%);
  margin-left: 24px;
  margin-top: 8px;
  padding: 2px;
`;

export const TagWrapper = styled.div`
  display: flex;
  flex-wrap: wrap;
  margin: 2px 0;
  min-height: 28px;
  max-width: calc(97.2307692rem / 6);
  white-space: normal;
`;

export const Button = styled.button`
  cursor: pointer;
  padding: 0.8rem;
  border-radius: 6px;
  font-size: 12px;

  &.apply_btn {
    background-color: hsl(206, 100%, 52%);
    color: hsl(0, 0%, 100%);
  }

  &.apply_btn:hover {
    background-color: hsl(206, 100%, 40%);
  }

  &.cancel_btn {
    color: hsl(206, 100%, 40%);
  }

  &.cancel_btn:hover {
    background-color: hsl(206, 100%, 97%);
  }
`;
