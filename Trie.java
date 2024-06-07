class Trie {

    String isEnd;
    Trie[] nodes;

    Trie() {
        nodes = new Trie[26];
        isEnd = null;
    }

    void insert(String s) {

        int i = 0;
        Trie head = this;

        while (i < s.length()) {
            Trie node = head.nodes[s.charAt(i) - 'a'];

            if (node == null) {
                node = new Trie();
                head.nodes[s.charAt(i) - 'a'] = node;
            }

            head = node;
            i++;
        }

        head.isEnd = s;
    }

    String get(String s) {

        int i = 0;
        Trie head = this;

        while (i < s.length()) {
            Trie nxt = head.nodes[s.charAt(i) - 'a'];

            if (nxt == null)
                break;

            if (nxt.isEnd != null)
                return nxt.isEnd;

            head = nxt;
            i++;
        }

        return s;
    }

}
